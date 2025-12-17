package be.sander.adventofcode._2020.day4.model.validation;

public abstract class Validation<T> {
    protected T value;

    public Validation(T value) {
        this.value = value;
    }

    public final boolean validate(){
        return validateMinimal() && validateSpecifics();
    }

    public boolean validateMinimal() {
        return this.value != null;
    }

    abstract boolean validateSpecifics();

    @Override
    public String toString() {
        return "Validation{" +
                "value=" + value +
                '}';
    }
}
