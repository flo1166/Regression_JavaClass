# Regression_JavaClass
This code solves a regression problem. Two methods are implemented:
+ for linear regression (KQS)
+ for quadratic functions, transformed as a linear problem

Structure:
+ datapoints = build object where a datapoint consist of a week and product price
++ DataPoint = a simple datapoint with week and price
++ DatePointOverview = a abstract class to have datapoints relating to each other via DataPoint class and x and y array seperated (for calculating reasons)
+ mathfunctions = interface, which contracts the functions to implement (for global usage)
++ Regression = the interface to contract classes which want to interact
+ regression = two methods implemented in Java
++ LinearModel = implementation of the linear problem (KQS)
++ QuadraticFunction = implementation of the quadratic problem, with log transformation and then processed like a linear problem


