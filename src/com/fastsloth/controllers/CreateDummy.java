package com.fastsloth.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;
import com.fastsloth.dao.DAO;
import com.fastsloth.general.DogContainer.Name;
import com.fastsloth.general.DogContainer.OwnerName;
import com.fastsloth.general.DogContainer;
import com.fastsloth.general.DogContainer.Breed;
import com.fastsloth.general.DogContainer.DogGroup;
import com.fastsloth.general.DogContainer.Gender;
import com.fastsloth.general.DogContainer.DogClass;
import com.fastsloth.general.DogContainer.Day1;
import com.fastsloth.general.DogContainer.Day2;
import com.fastsloth.general.DogContainer.Day3;
import com.fastsloth.general.DogContainer.Membership;

class RandomName<E extends Enum<DogContainer.Name>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomName(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomOwner<E extends Enum<DogContainer.OwnerName>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomOwner(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomBreed<E extends Enum<DogContainer.Breed>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomBreed(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomGroup<E extends Enum<DogContainer.DogGroup>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomGroup(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomGender<E extends Enum<DogContainer.Gender>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomGender(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomClass<E extends Enum<DogContainer.DogClass>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomClass(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomDay1<E extends Enum<DogContainer.Day1>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomDay1(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomDay2<E extends Enum<DogContainer.Day2>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomDay2(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomDay3<E extends Enum<DogContainer.Day3>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomDay3(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}

class RandomMembership<E extends Enum<DogContainer.Membership>> {
	  Random RND = new Random();
	  E[] values;

	  public RandomMembership(Class<E> token) {
	    values = token.getEnumConstants();
	  }

	  public E random() {
	    return values[RND.nextInt(values.length)];
	  }
}
@WebServlet("/CreateDummy")
public class CreateDummy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO daoDog = new DAO();
		
		for(int i = 0; i < 100; i++) {
			RandomName<Name> one = new RandomName<Name>(Name.class);
			RandomOwner<OwnerName> two = new RandomOwner<OwnerName>(OwnerName.class);
			RandomBreed<Breed> three = new RandomBreed<Breed>(Breed.class);
			RandomGroup<DogGroup> four = new RandomGroup<DogGroup>(DogGroup.class);
			RandomGender<Gender> five = new RandomGender<Gender>(Gender.class);
			RandomClass<DogClass> six = new RandomClass<DogClass>(DogClass.class);
			RandomDay1<Day1> seven = new RandomDay1<Day1>(Day1.class);
			RandomDay2<Day2> eight = new RandomDay2<Day2>(Day2.class);
			RandomDay3<Day3> nine = new RandomDay3<Day3>(Day3.class);
			RandomMembership<Membership> ten = new RandomMembership<Membership>(Membership.class);
			
			int number = 0;
			String name = String.valueOf(one.random());
			String ownerName = String.valueOf(two.random());
			String breed = String.valueOf(three.random());
			String group = String.valueOf(four.random());
			String gender = String.valueOf(five.random());
			String dogClass = String.valueOf(six.random());
			String day1 = String.valueOf(seven.random());
			String day2 = String.valueOf(eight.random());
			String day3 = String.valueOf(nine.random());
			String email = "fastsloth.cs@gmail.com";
			String password = "notReal";
			String membership = String.valueOf(ten.random());
			
			if (breed == "Labrador_Retriever" || breed == "Nova_Scotia_Duck_Tolling_Retriever"
					|| breed == "Golden_Retriever") {
				group = "Group 1: Sporting Dogs";
			} else if (breed == "Beagle" || breed == "Dachshund"
					|| breed == "Greyhound" || breed == "Whippet") {
				group = "Group 2: Hounds";
			} else if (breed == "Boxer" || breed == "Siberian_husky"
					|| breed == "Dobermann" || breed == "Great_dane" 
					|| breed == "Akita" || breed == "Rottweiler" 
					|| breed == "English_Mastiff" || breed == "Newfoundland_dog") {
				group = "Group 3: Working Dogs";
			} else if (breed == "Bull_terrier" || breed == "Yorkshire_terrier") {
				group = "Group 4: Terriers";
			} else if (breed == "Chihuahua" || breed == "Maltese_dog"
					|| breed == "Shih_tzu" || breed == "Pomeranian") {
				group = "Group 5: Toys";
			} else if (breed == "Pug" || breed == "Poodle"
					|| breed == "French_bulldog" || breed == "Chow_chow" || breed == "Bulldog") {
				group = "Group 6: Non-sporting Dogs";
			} else if (breed == "German_Shepherd" || breed == "Border_collie"
					|| breed == "Old_English_Sheepdog") {
				group = "Group 7: Herding";
			}
			
			if(breed == "Nova_Scotia_Duck_Tolling_Retriever") {
				breed = "Nova Scotia Duck Tolling Retriever";
			} else if(breed == "Border_collie") {
				breed = "Border Collie";
			} else if(breed == "Old_English_Sheepdog") {
				breed = "Old English Sheepdog";
			} else if(breed == "Newfoundland_dog") {
				breed = "Newfoundland Dog";
			} else if(breed == "Bull Terrier") {
				breed = "Bull Terrier";
			} else if(breed == "English_Mastiff") {
				breed = "English Mastiff";
			} else if(breed == "Yorkshire_terrier") {
				breed = "Yorkshire Terrier";
			} else if(breed == "French_bulldog") {
				breed = "French Bulldog";
			} else if(breed == "Siberian_husky") {
				breed = "Siberian Husky";
			} else if(breed == "Maltese_dog") {
				breed = "Maltese dog";
			} else if(breed == "Golden_Retriever") {
				breed = "Golden Retriever";
			} else if(breed == "Labrador_Retriever") {
				breed = "Labrador Retriever";
			} else if(breed == "German_Shepherd") {
				breed = "German Shepherd";
			} else if(breed == "Shih_tzu") {
				breed = "Shih Tzu";
			} else if(breed == "Great_dane") {
				breed = "Great Dane";
			} else if(breed == "Chow_chow") {
				breed = "Chow Chow";
			} else if(breed == "Bull_terrier") {
				breed = "Bull Terrier";
			} 
			
			Dog dog = new Dog(number, name, ownerName, breed, group, gender, dogClass, day1, day2, day3, email, password, membership);
			
			daoDog.addDog(dog);
			
		}		
		response.sendRedirect("index.html");
	}
}