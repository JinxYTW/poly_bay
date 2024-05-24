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
  static async bid(id) {
    const response = await fetch(`http://127.0.0.1:8080/bid/${id}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
    });

    if(response.status === 200) {
      return true;
    } else {
      return false;
    }
  }
}
export {ProductsService}