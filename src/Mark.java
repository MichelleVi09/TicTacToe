public enum Mark {
    x, o , EMPTY;

    @Override
    public String toString() {
        return switch(this){
            case x -> "x";
            case o ->  "o";
            case EMPTY -> " ";
        };
    }
}
