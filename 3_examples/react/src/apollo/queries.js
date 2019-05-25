import gql from 'graphql-tag'

export const ORDERS = gql`
  query Orders {
    orders {
      orderId
      delivery
      delivered
      items {
        id
        name
        price
      }
    }
  }
`

export const DISHES = gql`
  query AvailableDishes {
    dishes {
      id
      name
      price
      ingredients {
        id
        name
      }
    }
  }
`
