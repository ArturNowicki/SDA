package com.sda.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ExercisesIterator {

	/**
	 * Iterator - interface, ktory pozwala "przechodzic" (iterowac) przez
	 * kolekcje. Przejscie ma miejsce tylko w jednym kierunku - od poczatku do
	 * konca kolekcji. Iterowac po kolekcji mozna tylko raz. Podczas iteracji
	 * mozna usuwac lub zwracac obiekty.
	 */
	@Test
	public void basicOprations() {
		List<String> list = new ArrayList<String>();
		list.add("Romek");
		list.add("Tomek");
		list.add("Tytus");

		// Uzyskiwanie iteratora. Ma go każda kolekcja.
		Iterator<String> it = list.iterator();

		// Mozemy sprawdzic czy iterator ma kolejna wartosc (iterowac mozemy
		// tylko raz).
		boolean next = it.hasNext();
		System.out.println(next);

		// Mozemy uzyskac kolejna wartosc
		String firstValue = it.next();
		System.out.println(firstValue);

		// Mozemy rowniez usunac element. PODCZAS ITEROWANIA!
		it.remove();
		System.out.println(list);

		// Jesli zaiterujemy za daleko zostanie rzucony blad.
		System.out.println(it.next());
		System.out.println(it.next());
		try {
			System.out.println(it.next());
		} catch (NoSuchElementException nsee) {
			System.out.println("Dotarles za daleko. Blad: " + nsee);
		}

		// Aby nie rzucac bledow uzywa sie zazwyczaj standardowej konstrukcji
		Iterator<String> secondIterator = list.iterator();
		while (secondIterator.hasNext()) {
			String value = secondIterator.next();
			System.out.println(value);
		}
	}

	/**
	 * Przy pomocy Iteratora usun z listy integers wszystkie parzyste liczby.
	 */
	@Test
	public void removeOdds() {
		int count = 10000;
		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			integers.add(i);
		}
		Iterator<Integer> it = integers.iterator();
		while (it.hasNext()) {
			if (it.next() % 2 == 0)
				it.remove();
		}
		List<Integer> odds = new ArrayList<Integer>();
		for (int i = 1; i < count; i = i + 2) {
			odds.add(i);
		}
		Assert.assertThat(integers, CoreMatchers.is(odds));
	}

	/**
	 * Procz iteratora rowniez istnieje ListIterator. Rozszerza on dzialania
	 * Iteratora o iteracje w dwie strony, jak rowniez modifykacje wpisow. Maja
	 * do niego dostep wszystkie implementacje klasy List.
	 */
	@Test
	public void listIteratorOperations() {
		List<String> list = new ArrayList<String>();
		for (Integer i = 10; i < 20; i++) {
			list.add(i.toString());
		}
		ListIterator<String> listIterator = list.listIterator();

		// Mamy oczywiscie dostep do wszstkiego, czego mielismy w zwyklym
		// Iteratorze.
		System.out.println(listIterator.hasNext());
		System.out.println(listIterator.next());

		// Ale teraz mamy dodatkowe funkcjonalnosci
		String value = listIterator.next();
		String previousValue = listIterator.previous();
		System.out.println(value);
		System.out.println(previousValue);

		// A teraz jaka bedzie wartosc?
		String againNext = listIterator.next();
		System.out.println(againNext);

		// Podczas iterowania rowniez mozemy zmieniac wartosci.
		String currValue = listIterator.next();
		System.out.println(currValue);
		System.out.println(list);
		listIterator.set("brand new");
		System.out.println(list);
	}

	/**
	 * No i czas na zadanie! Tym razem celem jest wykorzystac ListIterator by na
	 * liscie numbers przeprowadzic nastepujaca operacje. Nalezy potroic dany
	 * element wtedy kiedy kolejny element jest podzielny przez 3. Np. majac
	 * liste [1, 2, 3, 4, 5, 6] przeksztalcona lista powinna miec wartosc [1, 6,
	 * 3, 4, 15, 6].
	 */
	@Test
	public void douleIfNextIsEven() {
		int listSize = 100, divideBy = 5;
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < listSize; i++) {
			numbers.add(i);
		}
		
		ListIterator<Integer> it = numbers.listIterator();
		while (it.hasNext()) {
			if (it.next() % divideBy == 0) {
				it.previous();
				if(it.hasPrevious()) {
					it.set(it.previous()*3);
					it.next();
					it.next();
				} else {
					it.next();					
				}
			}
		}
		List<Integer> forTest = new ArrayList<Integer>();
		for (int i = 0; i < listSize; i++) {
			if (i != listSize -1 && (i + 1) % divideBy == 0) {
				forTest.add(3 * i);
			} else {
				forTest.add(i);
			}
		}
		Assert.assertThat(numbers, CoreMatchers.is(forTest));

	}
}
