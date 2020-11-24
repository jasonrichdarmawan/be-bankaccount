package com.personal.bebankaccount.queue;

import com.personal.bebankaccount.mapper.Transactions_ProgressMapper;
import com.personal.bebankaccount.model.TransactionRabbitMQModel;
import com.personal.bebankaccount.model.TransferModel;
import com.personal.bebankaccount.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@SuppressWarnings("unused") // managed by TransactionsMQ
@Component
public class TransactionsReceiver {

  @Autowired
  TransferService transferService;

  @Autowired
  Transactions_ProgressMapper transactionsProgressMapper;

  public void transfer(TransactionRabbitMQModel transactionRabbitMQModel) {
    Map<String, Object> response = transferService.transfer(transactionRabbitMQModel.getSource(), new TransferModel(transactionRabbitMQModel.getDestination(), transactionRabbitMQModel.getDestination_Type(), transactionRabbitMQModel.getTransaction_Value()));
    while (transactionsProgressMapper.updateMessage_Code((int) response.get("message_code"), transactionRabbitMQModel.getProgress_ID()) != 1) {
      System.out.println("TransactionsReceiver error");
    }
  }
}
