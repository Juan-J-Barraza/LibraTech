
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book;

/**
 *
 * @author Juan
 */
public interface IRemoveStockCommands {
    
    public void removeStock(int amount, String title)
            throws Exception;
}
