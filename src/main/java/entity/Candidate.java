package entity;

public class Candidate {

    private int id;
    private String president;
    private String visce;
    private String presidentImage;
    private String party;
    private int votes;

    public Candidate(int id, String president, String visce, String presidentImage, String party, int votes) {
        this.id = id;
        this.president = president;
        this.visce = visce;
        this.presidentImage = presidentImage;
        this.party = party;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVisce() {
        return visce;
    }

    public void setVisce(String visce) {
        this.visce = visce;
    }

    public String getPresidentImage() {
        return presidentImage;
    }

    public void setPresidentImage(String presidentImage) {
        this.presidentImage = presidentImage;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}