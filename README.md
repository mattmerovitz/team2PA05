# cs12bspr20Simulation

This is a simple simulator of the geographical spread of an infection disease.
The primary purpose of this code is to help learn about inheritance in Java.

The simulation is performed on a 2d grid (Country.places) where the people are distributed (Country.population)
with at most one person per grid point.  In each tick of the simulation, the people try to move to another
grid point and after everyone has moved the infected people spread the virus to some of their neighbors.

This is clearly a very simple model, but it does allow one to see what happens when shelter-in-place orders are given
and some percentage of the populations follows those orders. It also allows you to see the effect of population density
on disease spread.  

None of this can be applied directly to the covid-19 pandemic because this model is too simple,
but it can help give some insights into the factors impacting the geographical spread of infectious diseases in general.

Part I
You are to make Person into an Abstract class where the method tryToMove is abstract
and create a new subclass of Person called Skeptic which always tries to move every tick.
This is mostly just rearranging code, there are no new algorithms to write here. Its is a kind of
refactoring to clean up the code.
Try different combinations of parameters on the 10 by 40 board.
Make some observations about these simulations.
Compare the simulations when everyone but essential people stay at home
and when everyone is a skeptic. Are there any differences?

Part II
Create a FrequentFlier subclass of Person. When this person move they jump to a random, unoccupied
space on the board. This is similar to the code in the placePopulation method of the Population class.
Modify the RunSimulation so that it take six parameters where the last is the number of FrequentFliers.

Part III
Create a new subclass of Person of your own choice.  For example you can add people who
recover more quickly or slowly (change Person.recoveryTime)
are more or less likely to get infected when exposed (change Person.infectProb)
lose their immunity (i.e change from recovered back to normal after some time)
always move if there is some neighboring space available
only move once every 7 days
Incorporate this new class in your model and make some observations about how it changes things.

Part IV.
One thing you'll observe is that there is quite a bit of random chance that will make different runs with the same parameters have completely different results. One time everyone will get infected, then next time only a handful.  Modify the code so that it runs 100 (or more) simulations and then reports on the average number of days it takes until there are no new infections, as well as the average number of people infected (and eventually recovered), and the maximum number of people infected at any one time.

You will want to create a new Class for this, call it AnalyzeSimulation which will
take an additional parameter (then number of repetitions to run) and will not do any of the printouts except for the final result.  You might want it to print one line for each simulation:
e.g. numOfDays, numOfInfected, peakInfectedLevel

This will let you start to get a sense of how these different policies affect the viral spread.

Run some experiments and try to estimate the effect of a StayAtHome policy compared to a Skeptic policy.

You should upload a link to your Git Repository to Latte when you are done and include a reflection where you make remarks about what you have learned if anything from this PA. This can be about new Java concepts or about Viral spread.
