package Player;

class Player {
    private int playerId;
    private String playerName;
    private String position;
    private int goals;
    private int assists;
    private double rating;

    public Player(int playerId, String playerName, String position,
                  int goals, int assists, double rating) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.rating = rating;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPosition() {
        return position;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public double getRating() {
        return rating;
    }

    public void displayPlayerInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Name: " + playerName);
        System.out.println("Position: " + position);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Rating: " + rating);
        System.out.println("-------------------------");
    }
}

class Team {
    private String countryName;
    private Player[] squad;
    private int matchesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsScored;
    private int goalsConceded;

    public Team(String countryName, Player[] squad, int matchesPlayed,
                int wins, int draws, int losses,
                int goalsScored, int goalsConceded) {

        this.countryName = countryName;
        this.squad = squad;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    public String getCountryName() {
        return countryName;
    }

    public Player[] getSquad() {
        return squad;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int calculateGoalDifference() {
        return goalsScored - goalsConceded;
    }

    public void displayTeamInfo() {
        System.out.println("\nCountry: " + countryName);
        System.out.println("Matches Played: " + matchesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Draws: " + draws);
        System.out.println("Losses: " + losses);
        System.out.println("Goals Scored: " + goalsScored);
        System.out.println("Goals Conceded: " + goalsConceded);
        System.out.println("Goal Difference: " + calculateGoalDifference());
    }
}

class WorldCupAnalyzer {

    public int calculateTeamPoints(Team t) {
        return (t.getWins() * 3) + (t.getDraws());
    }

    private double averageRating(Team t) {
        Player[] players = t.getSquad();
        double sum = 0;

        for (Player p : players) {
            sum += p.getRating();
        }

        return sum / players.length;
    }

    public Team findChampionTeam(Team[] teams) {

        Team champion = teams[0];

        for (int i = 1; i < teams.length; i++) {

            int currentPoints = calculateTeamPoints(teams[i]);
            int championPoints = calculateTeamPoints(champion);

            if (currentPoints > championPoints) {
                champion = teams[i];
            }

            else if (currentPoints == championPoints) {

                if (teams[i].calculateGoalDifference() >
                        champion.calculateGoalDifference()) {

                    champion = teams[i];
                }

                else if (teams[i].calculateGoalDifference() ==
                        champion.calculateGoalDifference()) {

                    if (teams[i].getGoalsScored() >
                            champion.getGoalsScored()) {

                        champion = teams[i];
                    }

                    else if (teams[i].getGoalsScored() ==
                            champion.getGoalsScored()) {

                        if (averageRating(teams[i]) >
                                averageRating(champion)) {

                            champion = teams[i];
                        }
                    }
                }
            }
        }

        return champion;
    }

    public Player findGoldenBootWinner(Team[] teams) {

        Player winner = teams[0].getSquad()[0];

        for (Team team : teams) {

            for (Player p : team.getSquad()) {

                if (p.getGoals() > winner.getGoals()) {
                    winner = p;
                }

                else if (p.getGoals() == winner.getGoals()) {

                    if (p.getAssists() > winner.getAssists()) {
                        winner = p;
                    }

                    else if (p.getAssists() == winner.getAssists()) {

                        if (p.getRating() > winner.getRating()) {
                            winner = p;
                        }
                    }
                }
            }
        }

        return winner;
    }

    public Team createLegendaryTeam(Team originalTeam) {

        Player[] oldPlayers = originalTeam.getSquad();
        Player[] newPlayers = new Player[oldPlayers.length];

        for (int i = 0; i < oldPlayers.length; i++) {

            double newRating = oldPlayers[i].getRating() + 0.5;

            if (newRating > 10.0)
                newRating = 10.0;

            newPlayers[i] = new Player(
                    oldPlayers[i].getPlayerId(),
                    oldPlayers[i].getPlayerName(),
                    oldPlayers[i].getPosition(),
                    oldPlayers[i].getGoals() + 5,
                    oldPlayers[i].getAssists() + 3,
                    newRating
            );
        }

        int newGoalsConceded =
                Math.max(0, originalTeam.getGoalsConceded() - 2);

        return new Team(
                "LEGENDS-" + originalTeam.getCountryName(),
                newPlayers,
                originalTeam.getMatchesPlayed(),
                originalTeam.getWins() + 2,
                originalTeam.getDraws(),
                originalTeam.getLosses(),
                originalTeam.getGoalsScored() + 10,
                newGoalsConceded
        );
    }
}

public class Main {

    public static void main(String[] args) {

        Player[] argentina = {
                new Player(1, "Messi", "Forward", 7, 3, 9.8),
                new Player(2, "Alvarez", "Forward", 4, 2, 8.9),
                new Player(3, "Mac Allister", "Midfielder", 2, 3, 8.5),
                new Player(4, "Martinez", "Goalkeeper", 0, 0, 8.7)
        };

        Player[] france = {
                new Player(5, "Mbappe", "Forward", 8, 2, 9.7),
                new Player(6, "Griezmann", "Midfielder", 3, 5, 8.8),
                new Player(7, "Giroud", "Forward", 4, 1, 8.4),
                new Player(8, "Lloris", "Goalkeeper", 0, 0, 8.2)
        };

        Player[] brazil = {
                new Player(9, "Neymar", "Forward", 5, 4, 9.5),
                new Player(10, "Vinicius", "Forward", 3, 3, 8.9),
                new Player(11, "Casemiro", "Midfielder", 2, 1, 8.6),
                new Player(12, "Alisson", "Goalkeeper", 0, 0, 8.8)
        };

        Player[] germany = {
                new Player(13, "Musiala", "Midfielder", 4, 2, 8.9),
                new Player(14, "Havertz", "Forward", 3, 1, 8.4),
                new Player(15, "Gundogan", "Midfielder", 2, 3, 8.7),
                new Player(16, "Neuer", "Goalkeeper", 0, 0, 8.5)
        };

        Team t1 = new Team("Argentina", argentina, 7, 6, 0, 1, 15, 8);
        Team t2 = new Team("France", france, 7, 5, 1, 1, 16, 8);
        Team t3 = new Team("Brazil", brazil, 5, 4, 0, 1, 10, 3);
        Team t4 = new Team("Germany", germany, 3, 1, 1, 1, 6, 5);

        Team[] teams = {t1, t2, t3, t4};

        WorldCupAnalyzer analyzer = new WorldCupAnalyzer();

        System.out.println("===== TEAM & PLAYER INFORMATION =====");

        for (Team t : teams) {

            t.displayTeamInfo();

            for (Player p : t.getSquad()) {
                p.displayPlayerInfo();
            }
        }

        Team champion = analyzer.findChampionTeam(teams);

        System.out.println("\n===== CHAMPION TEAM =====");
        champion.displayTeamInfo();

        Player goldenBoot = analyzer.findGoldenBootWinner(teams);

        System.out.println("\n===== GOLDEN BOOT WINNER =====");
        goldenBoot.displayPlayerInfo();

        Team legendaryTeam = analyzer.createLegendaryTeam(champion);

        System.out.println("\n===== LEGENDARY TEAM =====");
        legendaryTeam.displayTeamInfo();

        for (Player p : legendaryTeam.getSquad()) {
            p.displayPlayerInfo();
        }
    }
}