import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    transactions: []
  };

  async componentDidMount() {
    const response = await fetch('/transactions');
    const body = await response.json();
    this.setState({ transactions: body, isLoading: false });
  }

  render() {
    const {transactions, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Transactions List</h2>
            {transactions.map(transaction =>
              <div key={transaction.id}>
                {transaction.id} -- {transaction.customerId} -- {transaction.description} -- {transaction.points}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;