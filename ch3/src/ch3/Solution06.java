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
		
		public Animal dequeue(){
			if(dogs.size()==0){
				return dequeueCats();
			}
			else if(cats.size()==0){
				return dequeueDogs();
			}
			Dogs dog=dogs.peek();
			Cats cat=cats.peek();
			if(dog.isOlderThan(cat))
				return dequeueCats();
			else
				return dequeueDogs();
		}
		
		public Animal dequeueCats(){
			return cats.poll();
		}
		public Animal dequeueDogs(){
			return dogs.poll();
		}
	}
	
	
}
