package group.Reiz.Project.Adapters.DTOs.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDTO {
    private String name;
    private String description;
    private String category;
    private double price;
    private int stock;
    private String imageUrl;

}
