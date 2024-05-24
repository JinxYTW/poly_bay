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
        
    }
    #displayProducts(product){
        const productsElement = document.querySelector('.products');
        productsElement.insertAdjacentHTML('beforeend', `
            <div class="product">
                <span>${product.name}</span>
                <span>${product.owner}</span>
                <span>${product.bid}</span>
                <button>Enchérir</button>
            </div>
        `);
    }

    
}
export {ProductsView}