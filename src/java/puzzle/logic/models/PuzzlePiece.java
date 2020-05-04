package puzzle.logic.models;

import puzzle.logic.Location;

public class PuzzlePiece {
    private Location location;
    private int pieceNumber;

    public PuzzlePiece(Location location, int pieceNumber) {
        this.location = location;
        this.pieceNumber = pieceNumber;
    }

    // Start of getter setter
    public int getPieceNumber() {
        return pieceNumber;
    }
    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    // End of getter setter
    public PuzzlePiece getClone() {
        return new PuzzlePiece(location, pieceNumber);
    }
}
