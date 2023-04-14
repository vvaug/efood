package br.com.vvaug.efoodusers.usecase;

import br.com.vvaug.efoodusers.security.dto.User;

public interface GenerateJsonWebEncryptionPayload {

    String execute(User user);
}
