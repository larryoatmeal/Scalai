package com.sogima.ai

import Utilities._
import scala.collection.mutable.Set

object Search{




				
}

class Search(val problem: Problem){//need to use 'val' so type from problem can be used. https://groups.google.com/forum/#!topic/scala-user/3UCT0VZl2lQ

	
	case class Node(state: problem.State, actions: List[problem.Action], g: Double, h: Double, f: Double)

	def AStarGraph: Option[Node]  = {

		val exploredStates = Set[problem.State]()
		val fringe = makePriorityQueue[Node]{n => -n.f}//Priority given to lowest f value

		val startNode = Node(problem.initialState, List(), 0, problem.heuristic(problem.initialState), 0 + problem.heuristic(problem.initialState))

		fringe.enqueue(startNode)

		while(!fringe.isEmpty){
			val node = fringe.dequeue //Checkout next node with lowest f value
			exploredStates.add(node.state) //Add to closed set
			if(problem.isGoalState(node.state)){//If goal, good to go
				return Some(node)
			}

			problem.getSuccessors(node.state).foreach{//Expand nodes
				case problem.SuccessorFunction(state, action) if !exploredStates.contains(state) => {
					val g = node.g + problem.cost(action) 
					val h = problem.heuristic(state)
					val f = g + h
					val actions = node.actions :+ action

					val nextNode = Node(state, actions, g, h, f)
					fringe.enqueue(nextNode)
				}
				case _ => {} //If state already explored do nothing
			}
		}
		None
	}


}





