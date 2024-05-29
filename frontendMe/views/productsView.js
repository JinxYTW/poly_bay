import {ProductsService} from '../services/products-service.js';

class ProductsView{

    constructor(){
        
    }

    
    async displayProducts(){
        const products = await ProductsService.findAll();
        console.log(products);
        for (let product of products){
            this.#displayProducts(product);
        }
    //    this.#addButtonListeners();
        
    }
    #displayProducts(product){
        const productsElement = document.querySelector('.products');
        productsElement.insertAdjacentHTML('beforeend', `
            <div class="product">
                <span>${product.name}</span>
                <span>${product.owner}</span>
                <span id = "bid_${product.id}">${product.bid}</span>
                <button id="btn_${product.id}">Enchérir</button>
            </div>
        `);
        document.getElementById("btn_"+product.id).addEventListener
        ('click', async () => {
            const result = await ProductsService.bid(product.id);
            if(result){
                const bidElement = document.getElementById("bid_"+product.id);
                bidElement.textContent = result.bid;
            }

            
            
        });
    }
    

    
}
export {ProductsView}