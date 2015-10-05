package ch3;

import java.util.LinkedList;

public class Solution06 {
	
	abstract class Animal{
		private int order;
		private String name;
		
		public Animal(String s){
			this.name=s;
		}
		public void setOrder(int n){
			this.order=n;
		}
		public int getorder(){
			return this.order;
		}
		public boolean isOlderThan(Animal a){
			return order<a.getorder();
		}
	}
	
	class Cats extends Animal{
		public Cats(String s){
			super(s);
		}
	}
	
	class Dogs extends Animal{
		public Dogs(String s){
			super(s);
		}
	}
	
	class AnimalShelter{
		LinkedList<Dogs> dogs=new LinkedList<Dogs>();
		LinkedList<Cats> cats=new LinkedList<Cats>();
		private int order=0;
		
		public void enqueue(Animal a){
			a.setOrder(order);
			order++;
			if(a instanceof Cats){
				cats.addLast((Cats) a);
			}
			else if(a instanceof Dogs){
				dogs.addLast((Dogs) a);
			}
		}
		
		public Animal animalSelection(String name){
			if(name.equals("cat"))
				return catsDequeue();
			if(name.equals("dog"))
				return dogsDequeue();
			else return randomDequeue();
		}
		
		public Animal catsDequeue(){
			if(cats.size()!=0)
				return cats.poll();
			return null;
		}
		
		public Animal dogsDequeue(){
			if(dogs.size()==0){
				return dogs.poll();
			}
			return null;
		}
		
		public Animal randomDequeue(){
			if(dogs.size()==0){
				return catsDequeue();
			}
			else if(cats.size()==0){
				return dogsDequeue();
			}
			Dogs dog=dogs.peek();
			Cats cat=cats.peek();
			if(dog.isOlderThan(cat))
				return catsDequeue();
			else
				return dogsDequeue();
		}

		
	}
	
	
}
