const { createApp } = Vue;

createApp({
  data() {
    return {
      carts: [],
      total: 0,
      quantity: 0,
      phone: "",
      address: "",
      note: "",
      phoneRequired: false,
      phoneValid: false,
      addressRequired: false,
    };
  },
  mounted() {
    if (localStorage.getItem("carts")) {
      let carts = localStorage.getItem("carts");
      this.carts = JSON.parse(carts);
      this.updateCart();
    }
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const success = urlParams.get("success");
    
    if (success == "true") {
      this.carts = [];
      this.updateCart();
      localStorage.removeItem("carts");
    }
  },
  methods: {
    submit(e) {
      var _this = this;
      var phoneReg = /(84|0[3|5|7|8|9])+([0-9]{8})\b/;
      this.phoneRequired = false;
      this.phoneValid = false;
      this.addressRequired = false;
      if (this.phone == "") {
        this.phoneRequired = true;
      }
      if (phoneReg.test(this.phone) == false) {
        this.phoneValid = true;
      }
      if (this.address == "") {
        this.addressRequired = true;
      }
      console.log(this.phoneRequired);
      console.log(this.phoneValid);
      console.log(this.addressRequired);
      if (this.phoneRequired || this.phoneValid || this.addressRequired) {
        e.preventDefault();
      } else {
        // setTimeout(()=>{
        //   _this.carts = [];
        //   _this.updateCart();
        // },3000)
      }

      // if(!(confirm('Bạn có xác nhận mua ?'))) return false; return alert('Mua thành công')
    },
    changeCartQuantity(quantity, id) {
      var _this = this;
      if (this.carts.length > 0) {
        this.carts.map((item, index) => {
          if (item.id == id) {
            if (item.quantity <= 0) {
              _this.carts.splice(index, 1);
            }
          }
        });
      }
      this.updateCart();
    },
    addCart(id, name, price, image, status) {
      var cart = {
        id: id,
        title: name,
        price: price,
        image: image,
        status: status,
        quantity: 1,
      };

      if (this.carts.length > 0) {
        let flag = false;
        this.carts.map((item) => {
          if (item.id == id) {
            item.quantity++;
            flag = true;
          }
        });
        if (!flag) {
          this.carts.push(cart);
        }
      } else {
        this.carts.push(cart);
      }

      this.updateCart();
    },

    updateCart() {
      var _this = this;

      var tempQuantity = 0;
      var tempTotal = 0;
      this.carts.map((item) => {
        tempQuantity = tempQuantity + item.quantity;
        tempTotal += item.quantity * parseInt(item.price);
      });
      this.quantity = tempQuantity;
      this.total = tempTotal;
      localStorage.setItem("carts", JSON.stringify(this.carts));
    },
    formatNumber(number) {
      return new Intl.NumberFormat().format(number);
    },
    quantity() {},
  },
}).mount("#app");
