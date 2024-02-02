package org.example.projekat.IssuedBooks;

public class borrowed {
    private String memberIndex;
    private String bookcopyID;

    public borrowed() {
    }

    public borrowed(String memberIndex, String bookcopyID) {
        this.memberIndex = memberIndex;
        this.bookcopyID = bookcopyID;
    }

    public String getMemberIndex() {
        return memberIndex;
    }

    public String getBookcopyID() {
        return bookcopyID;
    }

    public void setMemberIndex(String memberIndex) {
        this.memberIndex = memberIndex;
    }

    public void setBookcopyID(String bookcopyID) {
        this.bookcopyID = bookcopyID;
    }

    @Override
    public String toString() {
        return "borrowed{" +
                "memberIndex='" + memberIndex + '\'' +
                ", bookcopyID='" + bookcopyID + '\'' +
                '}';
    }
}
