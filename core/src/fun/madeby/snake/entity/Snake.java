package fun.madeby.snake.entity;

import com.badlogic.gdx.utils.Array;

import fun.madeby.snake.config.GameConfig;

/**
 * Represents whole body of the snake
 */
public class Snake extends EntityBase{
    private SnakeHead head;
    private Direction direction = Direction.RIGHT;
    private final Array<BodyPart> bodyParts = new Array<>();

    private float xBeforeUpdate;
    private float yBeforeUpdate;

    public Snake() {
        this.head = new SnakeHead();
    }


    public void move() {
       // Snake head current position recorded:
       xBeforeUpdate = head.getX();
       yBeforeUpdate = head.getY();

        // Snake head moves
        if(direction.isLeft()) {
            head.updateX(-GameConfig.NORMAL_MOVES_EVERY.moves);
        } else if (direction.isRight()) {
            head.updateX(GameConfig.NORMAL_MOVES_EVERY.moves);
        }else if (direction.isUp()) {
            head.updateY(GameConfig.NORMAL_MOVES_EVERY.moves);
        } else {
            head.updateY(-GameConfig.NORMAL_MOVES_EVERY.moves);
        }
        
        // Snake Bodyparts immediately updated:
        updateBodyParts();
    }

    /**
     * tail, if it exists, constantly has its position updated to the last position of the head that is
     * retained in xBeforeUpdate and yBeforeUpdate
     */
    private void updateBodyParts() {
        if (bodyParts.size > 0) {
            BodyPart  tail = bodyParts.removeIndex(0);
            tail.setPosition(xBeforeUpdate, yBeforeUpdate);
            bodyParts.add(tail);

        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Array<BodyPart> getBodyParts() {
        return bodyParts;
    }

    /**
     * Mechanism for new body part is that it appears from behind existing parts once they have moved
     * past it, so they spawn under the snake head, a position that every BodyPart will travel through.
     */
    public void insertNewBodyPart() {
        BodyPart bodyPart = new BodyPart();
        bodyPart.setPosition(head.getX(), head.getY());
        //Insert at the beginning of array.
        bodyParts.insert(0, bodyPart);

    }

    public SnakeHead getHead() {
        return head;
    }
}
