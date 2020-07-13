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
package com.rpg.teststuff;

/**
 *
 * @author Dard
 */
public class GameLoop {
    
    public boolean RENDER_TIME = true;
    public int FPS = 60;
    public int UPS = 20;
    
    public void run(EventBuffers buffers){
        
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();
        boolean running = true;
        int secondsRunning = 0;
        int secondsRunning10 = 0;
        int secondsRunning100 = 0;
        int secondsRunning1000 = 0;
        int secondsRunning10000 = 0;

            while (running) {

                long currentTime = System.nanoTime();
                deltaU += (currentTime - initialTime) / timeU;
                deltaF += (currentTime - initialTime) / timeF;
                initialTime = currentTime;

                if (deltaU >= 1) {
                    getInput();
                    update();
                    ticks++;
                    deltaU--;
                }

                if (deltaF >= 1) {
                    render();
                    frames++;
                    deltaF--;
                }

                if (System.currentTimeMillis() - timer > 1000) {
                    secondsRunning++;
                    secondsRunning10++;
                    secondsRunning100++;
                    secondsRunning1000++;
                    secondsRunning10000++;

                    if (secondsRunning10 >= 10){
                        buffers.scanFast("asdf");
                        secondsRunning10 = 0;
                    }

                    if (secondsRunning100 >= 100){
                        buffers.scanModerate("asdf");
                        secondsRunning100 = 0;
                    }

                    if (secondsRunning1000 >= 1000){
                        buffers.scanSlow("asdf");
                        secondsRunning1000 = 0;
                    }

                    if (secondsRunning10000 >= 10000){
                        buffers.scanEvents("asdf");
                        secondsRunning10000 = 0;
                    }

                    buffers.addToBuffer("Test Garbage: " + secondsRunning);

                    if (RENDER_TIME) {
                        System.out.println(String.format("UPS: %s, FPS: %s, SecondsRunning: %s", ticks, frames, secondsRunning));
                    }
                    frames = 0;
                    ticks = 0;
                    timer += 1000;
                }
            }
    }
    
    public void getInput(){
        
    }
    
    public void update(){

    }
    
    public void render(){
        
    }
}
