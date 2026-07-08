# 🏥 Java OOP Pharmacy Management System
### Explorer HTML Link: [![Pharmacy System Architecture Dashboard](https://via.placeholder.com/800x400.png?text=Click+to+View+Interactive+Architecture+Dashboard)](https://ziyanlow.github.io/Java-OOP-Pharmacy-Management-System/)

A comprehensive, console-based Pharmacy Management System built using Java and Object-Oriented Programming (OOP) principles. This system streamlines daily operations for pharmacies, featuring role-based access control, inventory management, point-of-sale (POS) processing, membership handling, and automated reporting.

---

## 👥 Role-Based Access Control

The system supports secure login authentication and dynamically routes users to customized menus based on their assigned roles:

### 🛡️ Admin
Administrators have full operational control over the pharmacy.
* **Order Management:** Create, view, edit, and cancel orders.
* **Payment & Receipts:** Process active transactions and view historical payment receipts.
* **Inventory Control:** Add, edit, delete, and list medical equipment and medicines.
* **Staff Management:** Register new staff members, update details, or remove records.
* **Membership Control:** Full access to manage customer loyalty programs.
* **Reporting:** Generate and view detailed daily Sales, Shift, Equipment, and Medicine profit reports.

### 💵 Cashier
Cashiers have restricted access focused purely on customer-facing daily operations.
* **Order Management:** Create, view, and edit orders (cannot cancel).
* **Payment Processing:** Settle active orders via various payment methods.
* **Membership Control:** Register new members, search details, modify records, delete expired memberships, and process renewals.

---

## 🛠️ Core System Modules

### 🛒 1. Order & Point of Sale (POS)
* **Cart Management:** Add items via unique IDs and specify quantities.
* **Dynamic Calculations:** Automatically calculates subtotals, item counts, and grand totals.
* **Order Editing:** Append items, delete specific entries, or modify quantities before checkout.

### 💳 2. Payment Gateway
* **Payment Methods:** Supports Cash, Credit/Debit Card, and E-Wallet options.
* **Membership Discounts:** Automatically applies customized discounts (e.g., 10% for Silver, 20% for Gold members).
* **Validation:** Prevents underpayment and automatically calculates exact change for cash transactions.
* **Digital Receipts:** Generates a detailed breakdown of the transaction, including staff ID, timestamps, and applied discounts.

### 📦 3. Inventory Management
* **Medicines:** Categorized tracking (Liquid vs. Tablet/Capsule). Tracks manufacture dates, expiry dates, pricing, and descriptions.
* **Equipment:** Categorized tracking (Diagnostic vs. First Aid). Includes promotional pricing systems with start and end dates.
* **Automated Syncing:** Inventory quantities and statuses update dynamically as orders are processed.

### 🤝 4. Membership System
* **Lifecycle Management:** Track join dates, automated expiry tracking, and process 2-year renewals.
* **Record Modification:** Seamlessly update contact details or addresses for existing members.

### 📊 5. Automated Reporting
* **Sales Report:** Daily summaries showing receipt IDs, order details, total sales, and average sales per order.
* **Shift Report:** Tracks transaction volume separated by payment method.
* **Profitability Reports (Medicine & Equipment):** Calculates quantity sold, total cost, total revenue, and overall grand profit.

---

## ⚠️ System Input Validations

The system features robust error handling and input validation to maintain data integrity and prevent application crashes:
* **IC Numbers:** Must be strictly numeric and follow calendar logic for the date of birth (YYMMDD). The system detects invalid days (e.g., day '37' will be rejected).
* **Payment Inputs:** Rejects insufficient funds during checkout.
* **Unique IDs:** Prevents duplicate Staff usernames or duplicate Medicine/Equipment IDs.
* **Standardized Formats:** Enforces fixed options for attributes like Gender (Male/Female) and Staff Position (Admin/Cashier).

---

## 💻 Tech Stack & Architecture
* **Language:** Java
* **Paradigm:** Object-Oriented Programming (Inheritance, Polymorphism, Encapsulation, Abstraction)
* **Design:** Modular class structure (e.g., Abstract `Person` class extended by `Staff` and `Member`; specific item classes like `Equipment` and `Medicine` interacting with `Order` and `Payment`).
