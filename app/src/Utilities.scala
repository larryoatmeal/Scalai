package com.sogima.ai



object Utilities{

	def makePriorityQueue[T](compare: (T) => Double) = {
		import scala.math.Ordering.Implicits._
		import scala.collection.mutable.PriorityQueue

		new PriorityQueue[T]()(Ordering.by(compare)) 
	}






}