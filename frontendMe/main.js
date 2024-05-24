import {ProductsService}  from './services/products-service.js';
import { ProductsView } from './views/ProductsView.js';

async function run(){
    const productsView = new ProductsView();
    await productsView.displayProducts();
}


window.addEventListener('load', run);