package com.modelgw.example;

import java.util.ArrayList;
import java.util.List;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;
import com.azure.core.credential.KeyCredential;

public class App {
	public static void main(String[] args) {
		String modelgwApiKey = "sk-...";

		OpenAIClient client = new OpenAIClientBuilder()
				.credential(new KeyCredential(modelgwApiKey))
				.endpoint("https://azure-openai.api.modelgw.com")
				.buildClient();

		List<ChatRequestMessage> chatMessages = new ArrayList<>();
		chatMessages.add(new ChatRequestUserMessage("Hello there!"));

		ChatCompletions chatCompletions = client.getChatCompletions("auto",
				new ChatCompletionsOptions(chatMessages));

		for (ChatChoice choice : chatCompletions.getChoices()) {
			ChatResponseMessage message = choice.getMessage();
			System.out.println(message.getContent());
		}
	}

}
