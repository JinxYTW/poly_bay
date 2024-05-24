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
        this.#addButtonListeners();
        
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
    #addButtonListeners() {
        const buttons = document.querySelectorAll('.product button');
        buttons.forEach(button => {
            button.addEventListener('click', async (event) => {
                const id = event.target.dataset.id;
                const result = await ProductsService.bid(id);
                if (result) {
                    location.reload();
                }
            });
        });
    }

    
}
export {ProductsView}