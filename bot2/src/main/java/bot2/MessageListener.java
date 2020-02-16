package bot2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.EmoteManager;

public class MessageListener extends ListenerAdapter {
	private static final String credentialFile = System.getProperty("user.home") + "/.store/khalili_bot/DiscordCredentials.ak";
	private static JDA jda;
	private ArrayList<String> sayings = new ArrayList<String>();
	
	
	public static void main(String[] args) throws LoginException  {
		jda = new JDABuilder(getCredentials()).build();
		jda.addEventListener(new MessageListener());
	}
	
	private static String  getCredentials() {
		String r = "";	
			try {
				BufferedReader dmInput = new BufferedReader(new FileReader(credentialFile));
				try {
					r = dmInput.readLine().trim();
					dmInput.close();
				} catch (IOException e) {
					return "";
				}
			} catch (FileNotFoundException e) {
				return "";
			}
			return r;
		}
	
	@Override
	public void onReady(ReadyEvent e) {
		sayings.add("Can I erase that?");
		sayings.add("There is a lot of material in here");
		sayings.add("Lets do an example");
		sayings.add("Am I going too fast");
		sayings.add("LITTLE ENDIAN!!!!");
		sayings.add("This is detail oriented");
		sayings.add("You do not have to memorize this");
		sayings.add("ATMEGA32A");
		sayings.add("Is this clear");
		sayings.add("Is everyone paying attention");
		sayings.add("I have to check your circuit");
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		if(event.getAuthor().getIdLong() == Long.valueOf("502278360936873996").longValue()) {
			if(Math.random()<25) {
				event.getChannel().sendMessage("Don't Blow a fuse Yasir").queue();
			}
			return;
		}
		if(event.getAuthor().getIdLong() == Long.valueOf("94574165213839360").longValue()) {
			if(event.getMessage().getContentStripped().toLowerCase().equals("khalili shutdown")) {
				jda.shutdown();
			}
			return;
		}
		double val = Math.random();
		if(val < 0.05) {
			int index = (int)(new Date().getTime()%sayings.size());
			event.getChannel().sendMessage(sayings.get(index)).queue();
		}
	}
	
}