package lesson19;

import java.util.*;
import java.io.*;

public class Skeptic extends Person {

  void tryToMoveRandomly() {

    int dx = random.nextInt(3)-1; // -1,0,1
    int dy = random.nextInt(3)-1; // -1,0,1

    if (dx == 0 && dy == 0){
      this.tryToMoveRandomly();
    }

    if (isOK(super.x+dx, super.y+dy, super.country)) {
      super.moveTo(super.x+dx, super.y+dy);
    }

  }

}
