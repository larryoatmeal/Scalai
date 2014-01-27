package com.sogima.ai





abstract class Problem{
	type State 
	type Action

	case class SuccessorFunction(state: State, action: Action)


	def initialState: State
	def getSuccessors(state: State): List[SuccessorFunction] //List of successor functions. (destination state as well as action)
	def isGoalState(state: State): Boolean
	

	def cost(action: Action): Double
	def heuristic(state: State): Double
}


