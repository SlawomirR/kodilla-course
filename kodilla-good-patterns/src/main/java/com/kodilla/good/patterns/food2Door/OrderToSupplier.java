package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public class OrderToSupplier {
    private long id;
    private String description;
    private Map<Integer, SupplierProduct> orderList;

    public OrderToSupplier(final long id, final String description, final Map<Integer, SupplierProduct> orderList) {
        this.id = id;
        this.description = description;
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, SupplierProduct> getOrderList() {
        return orderList;
    }


    public static final class OrderToSupplierBuilder {
        Map<Integer, SupplierProduct> orderList;
        private long id;
        private String description;

        private OrderToSupplierBuilder() {
        }

        public static OrderToSupplierBuilder aSupplierOrder() {
            return new OrderToSupplierBuilder();
        }

        public OrderToSupplierBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderToSupplierBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public OrderToSupplierBuilder withOrderList(Map<Integer, SupplierProduct> orderList) {
            this.orderList = orderList;
            return this;
        }

        public OrderToSupplier build() {
            return new OrderToSupplier(id, description, orderList);
        }
    }
}
