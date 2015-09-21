package aufgabe;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@XmlRootElement
public class User {
	private List<Address> listOfAddresses = new ArrayList<Address>();
	private List<String> listOfTelephoneNumbers = new ArrayList<String>();
	private String birthday;

	public User() {
	}

	public User(List<Address> listOfAddresses, List<String> listOfTelephoneNumbers, String birthday) {
		this.listOfAddresses = listOfAddresses;
		this.listOfTelephoneNumbers = listOfTelephoneNumbers;
		this.birthday = birthday;
	}

	public void setAddresses(List<Address> addresses) {
		this.listOfAddresses = addresses;
	}

	@XmlElementWrapper
	@XmlElement(name = "address", type = Address.class)
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	@XmlElementWrapper
	@XmlElement(name = "telephone-number")
	public List<String> getListOfTelephoneNumbers() {
		return listOfTelephoneNumbers;
	}

	public void setListOfTelephoneNumbers(List<String> listOfTelephoneNumbers) {
		this.listOfTelephoneNumbers = listOfTelephoneNumbers;
	}

	@XmlElement
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 
	 * // * @return the user's age in month
	 */
	public int getAgeInMonths() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime birthday = formatter.parseDateTime(this.birthday);
		Months months = Months.monthsBetween(birthday, new DateTime());
		return months.getMonths();
	}

	@Override
	public String toString() {
		return "User [listOfAddresses=" + listOfAddresses + ", listOfTelephoneNumbers=" + listOfTelephoneNumbers
				+ ", birthday=" + birthday + "]";
	}
}
