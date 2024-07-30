package com.ludhiya;

import java.util.*;

public class Main
{
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args)
    {
        Album album=new Album("Album1","Taylor Swift");
        album.addSong("Willow",4.5);
        album.addSong("Are you ready for it",3.5);
        album.addSong("Blank Space",4.5);
        album.addSong("Cruel Summer",5.0);
        album.addSong("Bad Blood",3.0);
        albums.add(album);

        album=new Album("Album2","DSP");

        album.addSong("Excuse Me",5.0);
        album.addSong("Kadal Vandale",4.5);
        album.addSong("Crazy Feeling",3.5);
        album.addSong("Uppenantha",5.5);
        album.addSong("Nannaku",5.0);

        albums.add(album);

        LinkedList<Song> playList1=new LinkedList<>();

        albums.get(0).addToPlaylist("Willow",playList1);
        albums.get(0).addToPlaylist("Blank Space",playList1);
        albums.get(1).addToPlaylist("Crazy Feeling",playList1);
        albums.get(1).addToPlaylist("Excuse Me",playList1);

        play(playList1);
    }
    private static void play(LinkedList<Song>playList)
    {
       Scanner sc=new Scanner(System.in);
       boolean quit=false;
       boolean forward=true;
        ListIterator<Song>listIterator= playList.listIterator();
        if(playList.size()==0)
        {
            System.out.println("PlayList is empty");
        }
        else
        {
            System.out.println("Now playing"+listIterator.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action=sc.nextInt();
            sc.nextLine();
            switch (action)
            {
                case 0:
                    System.out.println("Play List is complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing"+listIterator.next().toString());
                    }
                    else {
                        System.out.println("No song available reached to the end of the list ");
                         forward=false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing the song"+listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("we are playing the first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing the song"+listIterator.previous().toString());
                            forward=false;
                        }
                        else
                        {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward=true;
                        }
                        else
                        {
                            System.out.println("We are reached to  the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing"+listIterator.next().toString());
                        }
                        else
                        {
                            if(listIterator.hasPrevious())
                            {
                                System.out.println("Now playing "+listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }
    private static void printMenu()
    {
        System.out.println("All Available options:\n press");
        System.out.println("0 - to quit\n"+
                "1 - to plat the next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song>playList)
    {
        Iterator<Song>iterator= playList.iterator();
        System.out.println("----------");
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("----------");
    }
}
