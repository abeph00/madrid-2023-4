import { rest } from "msw";

export const handlers = [
  rest.get('/products', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json([
        {
          "id": 1,
          "name": "Product 1",
          "price": 39.95,
          "category": "Pants",
          "imageUrl": "/assets/pants_a.jpg"
        }
      ]),
    )
  }),
  rest.get('/products/categories', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json([
        "Pants",
        "Dresses",
        "Jackets",
        "Sweaters"
      ]),
    )
  }),
  rest.get('/report-summary', (req, res, ctx) => {

    return res(
      ctx.status(200),
      ctx.json({
        "totalProducts": 6,
        "totalOrders": 6,
        "totalSales": 6000.95,
        "totalProductsByCategory": [
          {
            "category": "Pants",
            "productsCount": 6
          }
        ]
      }),
    )
  }),
  rest.get('/orders/:orderId', (req, res, ctx) => {
    const orderId = req.params.orderId;
    switch (orderId) {
      case 1:
        return res(
          ctx.status(200),
          ctx.json([
            {
              "id": 1,
              "date": "2023-02-15T17:32:28Z",
              "status": "approved",
              "totalPrice": 90.95,
              "itemsCount": 10,
              "products": [
                {
                  "id": 1,
                  "name": "Product 1",
                  "price": 39.95,
                  "category": "Pants",
                  "imageUrl": "/assets/products/pant_a.jpg"
                },
                {
                  "id": 2,
                  "name": "Product 2",
                  "price": 39.95,
                  "category": "Jacket",
                  "imageUrl": "/assets/products/jacket_a.jpg"
                }
              ]
            }
          ]),
        )
      default:
        return res(
          ctx.status(200),
          ctx.json([]),
        )
    }
  }),
  rest.get('/orders', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json([
        {
          "id": 1,
          "date": "2023-02-15T17:32:28Z",
          "totalPrice": 90.95,
          "itemsCount": 10,
          "status": "approved"
        }
      ]),
    )
  }),
  rest.get('/ranking', (req, res, ctx) => {
    const type = req.url.searchParams.get('type');
    const toDate = req.url.searchParams.get('toDate');
    const fromDate = req.url.searchParams.get('fromDate');
    console.log("date", toDate, fromDate)
    switch (type) {
      case "units":
        return res(
          ctx.status(200),
          ctx.json({ "type": "UNITS", "productRank": [{ "id": 9, "name": "Sweater C", "price": 18.78, "category": "Sweaters", "imageUrl": "/assets/products/sweater_c.jpg", "rank": 1, "score": 7.0 }, { "id": 2, "name": "Pant B", "price": 12.44, "category": "Pants", "imageUrl": "/assets/products/pant_b.jpg", "rank": 2, "score": 6.0 }, { "id": 1, "name": "Pant A", "price": 10.13, "category": "Pants", "imageUrl": "/assets/products/pant_a.jpg", "rank": 3, "score": 5.0 }, { "id": 7, "name": "Sweater A", "price": 25.23, "category": "Sweaters", "imageUrl": "/assets/products/sweater_a.jpg", "rank": 4, "score": 5.0 }, { "id": 8, "name": "Sweater B", "price": 26.48, "category": "Sweaters", "imageUrl": "/assets/products/sweater_b.jpg", "rank": 5, "score": 5.0 }, { "id": 4, "name": "Dress A", "price": 76.33, "category": "Dresses", "imageUrl": "/assets/products/dress_a.jpg", "rank": 6, "score": 4.0 }, { "id": 3, "name": "Pant C", "price": 28.88, "category": "Pants", "imageUrl": "/assets/products/pant_c.jpg", "rank": 7, "score": 3.0 }, { "id": 6, "name": "Jacket B", "price": 42.58, "category": "Jackets", "imageUrl": "/assets/products/jacket_b.jpg", "rank": 8, "score": 2.0 }, { "id": 5, "name": "Jacket A", "price": 36.34, "category": "Jackets", "imageUrl": "/assets/products/jacket_a.jpg", "rank": 9, "score": 1.0 }] })
        )
      case "orders":
        return res(
          ctx.status(200),
          ctx.json({ "type": "ORDERS", "productRank": [{ "id": 2, "name": "Pant B", "price": 12.44, "category": "Pants", "imageUrl": "/assets/products/pant_b.jpg", "rank": 1, "score": 4.0 }, { "id": 8, "name": "Sweater B", "price": 26.48, "category": "Sweaters", "imageUrl": "/assets/products/sweater_b.jpg", "rank": 2, "score": 4.0 }, { "id": 1, "name": "Pant A", "price": 10.13, "category": "Pants", "imageUrl": "/assets/products/pant_a.jpg", "rank": 3, "score": 3.0 }, { "id": 3, "name": "Pant C", "price": 28.88, "category": "Pants", "imageUrl": "/assets/products/pant_c.jpg", "rank": 4, "score": 3.0 }, { "id": 4, "name": "Dress A", "price": 76.33, "category": "Dresses", "imageUrl": "/assets/products/dress_a.jpg", "rank": 5, "score": 3.0 }, { "id": 9, "name": "Sweater C", "price": 18.78, "category": "Sweaters", "imageUrl": "/assets/products/sweater_c.jpg", "rank": 6, "score": 3.0 }, { "id": 6, "name": "Jacket B", "price": 42.58, "category": "Jackets", "imageUrl": "/assets/products/jacket_b.jpg", "rank": 7, "score": 2.0 }, { "id": 5, "name": "Jacket A", "price": 36.34, "category": "Jackets", "imageUrl": "/assets/products/jacket_a.jpg", "rank": 8, "score": 1.0 }, { "id": 7, "name": "Sweater A", "price": 25.23, "category": "Sweaters", "imageUrl": "/assets/products/sweater_a.jpg", "rank": 9, "score": 1.0 }] })
        )
      case "amount":
        return res(
          ctx.status(200),
          ctx.json({ "type": "AMOUNT", "productRank": [{ "id": 4, "name": "Dress A", "price": 76.33, "category": "Dresses", "imageUrl": "/assets/products/dress_a.jpg", "rank": 1, "score": 305.32 }, { "id": 8, "name": "Sweater B", "price": 26.48, "category": "Sweaters", "imageUrl": "/assets/products/sweater_b.jpg", "rank": 2, "score": 132.4 }, { "id": 9, "name": "Sweater C", "price": 18.78, "category": "Sweaters", "imageUrl": "/assets/products/sweater_c.jpg", "rank": 3, "score": 131.46 }, { "id": 7, "name": "Sweater A", "price": 25.23, "category": "Sweaters", "imageUrl": "/assets/products/sweater_a.jpg", "rank": 4, "score": 126.15 }, { "id": 3, "name": "Pant C", "price": 28.88, "category": "Pants", "imageUrl": "/assets/products/pant_c.jpg", "rank": 5, "score": 86.64 }, { "id": 6, "name": "Jacket B", "price": 42.58, "category": "Jackets", "imageUrl": "/assets/products/jacket_b.jpg", "rank": 6, "score": 85.16 }, { "id": 2, "name": "Pant B", "price": 12.44, "category": "Pants", "imageUrl": "/assets/products/pant_b.jpg", "rank": 7, "score": 74.64 }, { "id": 1, "name": "Pant A", "price": 10.13, "category": "Pants", "imageUrl": "/assets/products/pant_a.jpg", "rank": 8, "score": 50.650000000000006 }, { "id": 5, "name": "Jacket A", "price": 36.34, "category": "Jackets", "imageUrl": "/assets/products/jacket_a.jpg", "rank": 9, "score": 36.34 }] })
        )
      default:
        return res(
          ctx.status(500),
          ctx.json({
            "error": "No tiene un tipo correcto"
          }),
        )
    }
  }),
];