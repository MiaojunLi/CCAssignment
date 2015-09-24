package ch4;

import java.util.ArrayList;
import java.util.Stack;

public class Solution07 {
	public static class Project{
		public enum State {BLANK,PARTIAL,COMPLETE};
		private State state =State.BLANK;
		public State getState(){
			return state;
		}
		public void setState(State st){
			state=st;
		}
		
	}
	Stack<Project> findBuildOrder(String[] projects,String[][]dependencies){
		Graph graph= buildGrph(projects,dependencies);
		return orderProjects(graph.getNodes());
	}
	
	Stack<Project> orderProjects(ArrayList<Project> projects){
		Stack<Project> stack=new Stack<Project>();
		for(Project project:projects){
			if(project.getState()==Project.State.BLANK){
				if(!doDFS(project,stack)){
					return null;
				}
			}
		}
		return stack;
	}
	
	boolean doDFS(Project project,Stack<Project> stack){
		if(project.getState()==Project.State.PARTIAL){
			return false;
		}
		if(project.getState()==Project.State.BLANK){
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children =project.getChildren();
			for(Project child:children){
				if(!doDFS(child,stack))
				return false;
			}
			project.setState(Project.State.COMPLETE);
				stack.push(project);
			}
		return true;	
		}
	Graph buildGraph(String[] projects,String[][] dependencies){};
	public class Graph{}
	
	
}
