package br.com.alura.auction.domain;

public class Bid {

    private User user;
    private Double value;

    public Bid(User user, Double value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        this.user = user;
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Bid other = (Bid) obj;
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        if (value == null) {
            return other.value == null;
        } else return value.equals(other.value);
    }
}