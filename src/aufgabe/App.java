package aufgabe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class App {

	public static Object getPojoFromXml(String fileName) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(User.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object pojo = unmarshaller.unmarshal(new File(fileName));
		return pojo;
	}

	public static void savePojoAsXml(Object object) throws FileNotFoundException, JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(object.getClass());
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshallerObj.marshal(object, new FileOutputStream("resources/user.xml"));
	}

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		// create user and save as xml
		List<Address> listOfAddresses = new ArrayList<Address>();
		listOfAddresses.add(new Address("Von-Quadt-Str. 27a", "51069", "Köln"));
		listOfAddresses.add(new Address("Holweider Str. 2a", "51065", "Köln"));
		List<String> listOfTelephoneNumbers = new ArrayList<String>();
		listOfTelephoneNumbers.add("0221 123456");
		listOfTelephoneNumbers.add("0221 837482");
		listOfTelephoneNumbers.add("0221 364726");
		User user = new User(listOfAddresses, listOfTelephoneNumbers, "1991-08-23");
		savePojoAsXml(user);

		// load user from xml and print user details
		User loadedUser = (User) getPojoFromXml("resources/user.xml");
		System.out.println(loadedUser);
		System.out.println("Der Nutzer ist " + loadedUser.getAgeInMonths() + " Monate alt.");
	}
}
