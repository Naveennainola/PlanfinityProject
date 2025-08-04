package dtos;

import java.util.Date;

public class EventDTO {
	
	private Integer eventId;
	private String title;
	private String description;
	private Date eventDate;
	private String location;
	private String category;
	private Integer capacity;
	private Integer price;
	private String imageBase64;
	private UserDTO organizer;
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public EventDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public EventDTO(Integer eventId, String title, String description, Date eventDate, String location,
			String imageBase64, UserDTO organizer, String category, Integer capacity, Integer price) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.location = location;
		this.imageBase64 = imageBase64;
		this.organizer = organizer;
		this.category = category;
		this.capacity = capacity;
		this.price = price;
	}

	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	public UserDTO getOrganizer() {
		return organizer;
	}
	public void setOrganizer(UserDTO organizer) {
		this.organizer = organizer;
	}
	
	

}
