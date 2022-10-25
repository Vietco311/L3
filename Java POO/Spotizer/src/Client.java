import java.util.ArrayList;

public class Client extends Utilisateur {

    public Client(String nNom, String nPrenom, String nUsername){
        super(nNom, nPrenom, nUsername);
    }

    public Playlist creerListeMusic(String nomPlaylist, ArrayList<Titre> lesMusiques){
        return new Playlist(nomPlaylist, lesMusiques, this);
    }
}
