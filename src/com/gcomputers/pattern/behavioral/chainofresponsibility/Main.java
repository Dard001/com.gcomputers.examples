/*
 * Copyright (C) 2020 Dard
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.gcomputers.pattern.behavioral.chainofresponsibility;

/*
* Chain of responsibility pattern is used to achieve loose coupling in software design where a request 
* from the client is passed to a chain of objects to process them. Later, the object in the chain will 
* decide themselves who will be processing the request and whether the request is required to be sent 
* to the next object in the chain or not.
*
* This pattern is recommended when multiple objects can handle a request and the handler doesn’t have 
* to be a specific object. Also, the handler is determined at runtime. Please note that a request not 
* handled at all by any handler is a valid use case.
*
* Where and When Chain of Responsibility pattern is applicable :
*
* - When you want to decouple a request’s sender and receiver
* - Multiple objects, determined at runtime, are candidates to handle a request
* - When you don’t want to specify handlers explicitly in your code
* - When you want to issue a request to one of several objects without specifying the receiver explicitly.
*
* https://www.geeksforgeeks.org/chain-responsibility-design-pattern/
*/

/**
 *
 * @author Dard
 */
public abstract class Main {
    public static void main(String[] args){
        
        //Instantiate X number of new Chain classes (also known as Handlers)
        Chain c1 = new NegativeProcessor(); //A Chain is a generic handler, the processor is a Concrete Handler which extends a Chain interface
        Chain c2 = new ZeroProcessor();
        Chain c3 = new PositiveProcessor();
        
        //Set the order of events
        c1.setNext(c2);
        c2.setNext(c3);
        
        //Tell the first Handler to process something
        c1.process(new ChainNumber(90));
        c1.process(new ChainNumber(-50));
        c1.process(new ChainNumber(0));
        c1.process(new ChainNumber(91));
        
        /*
        * Inspiration for this example was taken from: https://www.geeksforgeeks.org/chain-responsibility-design-pattern/
        */
    }
}
