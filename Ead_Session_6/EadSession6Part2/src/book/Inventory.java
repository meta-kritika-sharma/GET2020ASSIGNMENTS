package book;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventory {
	private int id;
	private String title;
	private String writer;
	private String publisher;
	private String publisherYear;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisherYear() {
		return publisherYear;
	}

	public void setPublisherYear(String publisherYear) {
		this.publisherYear = publisherYear;
	}

}
