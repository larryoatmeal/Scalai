package com.sogima.ai




class DummyProblem extends Problem{
	type State = Int 
	type Action = String

	def initialState = 1
	def getSuccessors(state: State) = {
		List(SuccessorFunction(state+3, s"GO TO ${state+3}"), SuccessorFunction(state-5, s"GO TO ${state-5}"))
	} 
	
	def isGoalState(state: State) = state == 11

	def cost(action: Action): Double = 1.0
	def heuristic(state: State): Double = Math.abs(state - 10).toDouble
}


object Master{
	def main(){
		println("AI Master-----------------")
		val s = new Search(new DummyProblem())
		println(s.AStarGraph)


	}


}




