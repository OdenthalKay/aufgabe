package aufgabe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	private String street;
	private String plz;
	private String town;

	public Address() {
	}

	public Address(String street, String plz, String town) {
		this.street = street;
		this.plz = plz;
		this.town = town;
	}

	@XmlElement
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@XmlElement
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement
	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", plz=" + plz + "]";
	}
}
