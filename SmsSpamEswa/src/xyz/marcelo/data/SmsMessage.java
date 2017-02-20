package xyz.marcelo.data;

import java.util.LinkedList;

public class SmsMessage {

	private String type;
	private String text;
	private LinkedList<String> words;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LinkedList<String> getWords() {
		return words;
	}

	public void setWords(LinkedList<String> words) {
		this.words = words;
	}

	public SmsMessage(String type, String text, LinkedList<String> words) {
		super();
		this.type = type;
		this.text = text;
		this.words = words;
	}

}
