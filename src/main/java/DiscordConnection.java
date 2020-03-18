import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class DiscordConnection extends ListenerAdapter {

    public static void startDiscord(){   // Inicialização do bot para conexão com discord com um token
        System.out.println("Discord Started");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token ="Njg4MDY5MTYwNDU3OTk0NDE4.Xmu-dg.oXrh5vxJ6BMQSBfu1psTKxfKqpM";
        builder.setToken(token);
        builder.addEventListener(new DiscordConnection());
        try{
            builder.buildAsync();
        }catch(LoginException ex){
            System.out.println("Não foi possivel fazer login");
        }
    }
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Mensagem:"+event.getMessage().getContentRaw());
        if(event.getAuthor().isBot()) return;//ele nao executa se for mensagem de bot
        if (event.getMessage().getContentRaw().equals("ligar")){ //Comando utlizado para iniciar o bot
            event.getChannel().sendMessage("Ola, como posso ajudar !").queue(); // mensagem que vai ser exibida após o bot ter sido ligado
        }
    }
}
