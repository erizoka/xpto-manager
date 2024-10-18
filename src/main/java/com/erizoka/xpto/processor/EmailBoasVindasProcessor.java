package com.erizoka.xpto.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.erizoka.xpto.entity.NovaContaCliente;

@Component
public class EmailBoasVindasProcessor implements ItemProcessor<NovaContaCliente, SimpleMailMessage>{

    @SuppressWarnings("null")
	@Override
    public SimpleMailMessage process(NovaContaCliente novaContaCliente) throws Exception {
        SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("xpto@no-reply.com");
		email.setTo(novaContaCliente.getCliente().getEmail());
		email.setSubject("Bem-vindo ao Banco XPTO!");
		email.setText(gerarTextoBoasVindas(novaContaCliente));
		return email;
    }

    private String gerarTextoBoasVindas(NovaContaCliente novaContaCliente) {
        StringBuilder writer = new StringBuilder();
        writer.append(String.format("Olá, %s!\n\n", novaContaCliente.getCliente().getNome()));
        writer.append("Seja muito bem-vindo(a) ao Banco XPTO! Sua nova conta foi criada com sucesso e estamos muito felizes em tê-lo(a) conosco.\n\n");
        writer.append("Você agora faz parte de uma instituição comprometida com sua segurança, praticidade e crescimento financeiro.\n" + 
                        "Abaixo estão os detalhes da sua conta:\n\n");
        writer.append(String.format("Tipo de Conta: %s\n", novaContaCliente.getConta().getTipo()));
        writer.append(String.format("Limite de Crédito: %s\n\n", novaContaCliente.getConta().getLimite()));
        writer.append("Agradecemos por confiar no Banco XPTO! Estamos prontos para oferecer a você a melhor experiência bancária.\n\n");
        writer.append("Atenciosamente,\nEquipe Banco XPTO\n");
        return writer.toString();
    }
}