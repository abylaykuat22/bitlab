package kz.bitlab.beans.services.impl;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
  public void sendMessage() {

    System.out.println("после добавления товара отправлено сообщение на почту");
  }
}
