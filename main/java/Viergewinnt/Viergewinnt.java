package Viergewinnt;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.ArrayList;

public class Viergewinnt {
    public Player player1;
    public Player player2;
    public int inventorySize;
    public String gui_name;
    public Material[] content;
    public ArrayList<Player> hasMove;

    public Viergewinnt(int inventorySize, String gui_name, Material[] content, Player player1, Player player2, ArrayList<Player> hasMove) {
        this.inventorySize = inventorySize;
        this.gui_name = gui_name;
        this.content = content;
        this.player1 = player1;
        this.player2 = player2;
        this.hasMove = hasMove;
    }

    public void openGUI(Player player1, Player player2, Inventory inv) {
        inv.setItem(0, createPlayerHead(this.player1));
        inv.setItem(8, createPlayerHead(this.player2));
        player1.openInventory(inv);
        player2.openInventory(inv);

    }

    public ArrayList<Player> switchPlayerWhoHasMove(ArrayList<Player> hasMove, Player clickedplayer, Player playerwithoutMove) {
        if (hasMove.contains(clickedplayer)) {
            hasMove.remove(clickedplayer);
            hasMove.add(playerwithoutMove);
        }
        return hasMove;
    }

    public ArrayList<Player> initializeHasMove(ArrayList<Player> hasMove, Player player1) {
        hasMove.clear();
        hasMove.add(player1);
        return hasMove;
    }

    public Inventory createInventory(int inventorySize, Material[] content, String gui_name) {
        Inventory inv = Bukkit.createInventory(null, inventorySize, gui_name);
        int i = 0;
        for (Material m : content) {
            inv.setItem(i, new ItemStack(m));
            i++;
        }
        return inv;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public ArrayList<Player> getHasMove() {
        return hasMove;
    }

    public void setHasMove(ArrayList<Player> noMove) {
        this.hasMove = noMove;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public String getGui_name() {
        return gui_name;
    }

    public void setGui_name(String gui_name) {
        this.gui_name = gui_name;
    }

    public Material[] getContent() {
        return content;
    }

    public void setContent(Material[] content) {
        this.content = content;
    }

    public Material[] editContent(int Slot, Material mat, Material[] content) {
        content[Slot] = mat;
        return content;
    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public ItemStack createPlayerHead(Player player) {
        ItemStack itemstack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) itemstack.getItemMeta();
        meta.setDisplayName(player.getName());
        meta.setOwningPlayer(player);
        itemstack.setItemMeta(meta);
        return itemstack;
    }

    public void checkForWin(Material[] content) {
        Player winner = null;
        int[][] grid =returnControlArray(content);
        int row=0;
        int col=0;
        for(int i=0;i<53;i++) {
            if (col == 9) {
                col = 0;
                row++;
            }
            winner = checkForSameRow(grid,row,col);
            if (winner == null) winner = checkForSameColoumn(grid,row,col);
            if (winner == null) winner = checkForDiagonaltoRight(grid,row,col);
            if (winner == null) winner = checkForDiagonaltoLeft(grid,row,col);
            col++;
            if(winner!=null)break;
        }
        if (winner != null) {
            this.getPlayer1().sendMessage("Gewinner ist " + winner.getName());
            this.getPlayer2().sendMessage("Gewinner ist " + winner.getName());
            this.getPlayer1().closeInventory();
            this.getPlayer2().closeInventory();
        }

    }

    private Player checkForDiagonaltoLeft(int[][] grid, int row, int col) {
        Player win = null;
        int rowDelta=-1;
        int colDelta=1;
        int matches=0;
        int oldtest=grid[row][col];
        for (int count = 0; count < 4; count++) {
            if (row < 6 && row >= 0 && col < 9 && col >= 0) {
                int test = grid[row][col];
                if (test==oldtest&&test!=0) {
                    matches++;
                    oldtest=test;
                }
            }
            row += rowDelta;
            col += colDelta;
        }
        if(matches==4){
            win = checkforWinner(oldtest);
        }
        return win;
    }

    private Player checkForDiagonaltoRight(int[][] grid, int row, int col) {
        Player win = null;
        int rowDelta=1;
        int colDelta=1;
        int matches=0;
        int oldtest=grid[row][col];
        for (int count = 0; count < 4; count++) {
            if (row < 6 && row >= 0 && col < 9 && col >= 0) {
                int test = grid[row][col];
                if (test==oldtest&&test!=0) {
                    matches++;
                    oldtest=test;
                }
            }
            row += rowDelta;
            col += colDelta;
        }
        if(matches==4){
            win = checkforWinner(oldtest);
        }
        return win;
    }

    public Player checkForSameColoumn(int[][] grid, int row, int col) {
        Player win = null;
        int rowDelta=1;
        int colDelta=0;
        int matches=0;
        int oldtest=grid[row][col];
        for (int count = 0; count < 4; count++) {
            if (row < 6 && row >= 0 && col < 9 && col >= 0) {
                int test = grid[row][col];
                if (test==oldtest&&test!=0) {
                    matches++;
                    oldtest=test;
                }
            }
            row += rowDelta;
            col += colDelta;
        }
        if(matches==4){
            win = checkforWinner(oldtest);
        }
        return win;
    }

    public Player checkForSameRow(int[][] grid, int row, int col) {
            Player win = null;
            int rowDelta=0;
            int colDelta=1;
            int matches=0;
            int oldtest=grid[row][col];
            for (int count = 0; count < 4; count++) {
                if (row < 6 && row >= 0 && col < 9 && col >= 0) {
                    int test = grid[row][col];
                    if (test==oldtest&&test!=0) {
                        matches++;
                        oldtest=test;
                    }
                }
                row += rowDelta;
                col += colDelta;
            }
            if(matches==4){
                win = checkforWinner(oldtest);
            }
            return win;
        }

    public Player checkforWinner(int number) {
        Player winner = null;
        if (number==1) {
            winner = this.player1;
        } else if (number==2) {
            winner = this.player2;
        }
        return winner;
    }
    public Material[] setPlayersPoint(Material[] content, Player player, int Slot) {
        int Slotspalte = Slot % 9;
        if ((0 <= Slot && Slot < 54)&&content[Slot].equals(Material.WHITE_STAINED_GLASS_PANE)) {
            while (content[Slotspalte].equals(Material.WHITE_STAINED_GLASS_PANE)) {
                Slotspalte = Slotspalte + 9;
                if (Slotspalte > 54) {
                    break;
                }
            }
            Slotspalte -= 9;
        }
        if (player.equals(this.player1)) {
            content[Slotspalte] = Material.BLUE_STAINED_GLASS_PANE;
        } else {
            content[Slotspalte] = Material.RED_STAINED_GLASS_PANE;
        }
        return content;
    }

    public void renewInventory(Player player1, Player player2, Material[] content, int inventorySize, String gui_name) {
        Inventory inv = Bukkit.createInventory(null, inventorySize, gui_name);
        ItemStack[] InventoryContent = new ItemStack[inventorySize];
        for (int x = 0; x < inventorySize; x++) {
            InventoryContent[x] = new ItemStack(content[x]);
        }
        inv.setContents(InventoryContent);
        inv.setItem(0, createPlayerHead(this.player1));
        inv.setItem(8, createPlayerHead(this.player2));
        player1.openInventory(inv);
        player2.openInventory(inv);
    }

    public Material[] resetInventory() {
        Material[] content = new Material[54];
        for (int i = 0; i < 54; i++) {
            content[i] = Material.WHITE_STAINED_GLASS_PANE;
            if (i % 9 == 8) {
                content[i] = Material.BLACK_STAINED_GLASS_PANE;
            }
            if (i % 9 == 0) {
                content[i] = Material.GREEN_STAINED_GLASS_PANE;
            }


        }
        return content;
    }

    public void setBorderforPlayerWithMove(Material[] content, Player playerwithMove) {
        if (this.player1.equals(playerwithMove)) {
            for (int i = 9; i < 54; ) {
                content[i] = Material.GREEN_STAINED_GLASS_PANE;
                i += 9;
            }
            for (int i = 17; i < 54; ) {
                content[i] = Material.BLACK_STAINED_GLASS_PANE;
                i += 9;
            }
        } else {
            for (int i = 17; i < 54; ) {
                content[i] = Material.GREEN_STAINED_GLASS_PANE;
                i += 9;
            }
            for (int i = 9; i < 54; ) {
                content[i] = Material.BLACK_STAINED_GLASS_PANE;
                i += 9;
            }
            this.content = content;
        }
    }
    public int[][] returnControlArray(Material[] content){
        int[][] carray= new int[6][9];
        int reihe=0;
        int spalte=0;
            for(Material m : content){
                if (m.equals(Material.BLUE_STAINED_GLASS_PANE)) {
                    carray[reihe][spalte]=1;
                }
                else if(m.equals(Material.RED_STAINED_GLASS_PANE)){
                    carray[reihe][spalte]=2;
                }
                else{
                    carray[reihe][spalte]=0;
                }
                spalte++;
                if(spalte==9){
                    reihe++;
                    spalte=0;
                }
                if(reihe==6)break;
            }
            return carray;
    }
}