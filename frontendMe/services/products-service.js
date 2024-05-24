class ProductsService {
  constructor() {
    
  }

  static async findAll() { 
    const response = await fetch('http://127.0.0.1:8080/products');

    if(response.status !== 404) {
      const data = await response.json();
      console.log(data);
      return data;
    }

  
}
}

export {ProductsService}