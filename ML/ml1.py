import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import mean_squared_error

# 데이터 로드
data = pd.read_csv('winequality-red.csv')

# 특성(X)과 타겟(y) 분리 (여기서는 'quality'를 타겟으로 설정)
X = data.drop('quality', axis=1)
y = data['quality']

# 데이터 표준화
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# 학습 데이터와 테스트 데이터 분리
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, random_state=42)

# 1. 정규 방정식
X_b_train = np.c_[np.ones((X_train.shape[0], 1)), X_train]  # 절편 추가
theta_best = np.linalg.inv(X_b_train.T.dot(X_b_train)).dot(X_b_train.T).dot(y_train)
print(theta_best)

# 2. 경사 하강법
def gradient_descent(X, y, learning_rate=0.01, n_iterations=1000):
    m = len(y)
    X_b = np.c_[np.ones((m, 1)), X]  # 절편 추가
    theta = np.random.randn(X_b.shape[1], 1)  # 초기 theta 값
    y = y.reshape(-1, 1)
    
    for iteration in range(n_iterations):
        gradients = 2/m * X_b.T.dot(X_b.dot(theta) - y)
        theta -= learning_rate * gradients
    
    return theta

theta_gd = gradient_descent(X_train, y_train.values)

# 3. 테스트 데이터에서 성능 비교
X_b_test = np.c_[np.ones((X_test.shape[0], 1)), X_test]

# 정규 방정식 결과
y_pred_normal_eq = X_b_test.dot(theta_best)
mse_normal_eq = mean_squared_error(y_test, y_pred_normal_eq)

# 경사 하강법 결과
y_pred_gd = X_b_test.dot(theta_gd)
mse_gd = mean_squared_error(y_test, y_pred_gd)

# 결과 출력
print(f"정규 방정식 MSE: {mse_normal_eq}")
print(f"경사 하강법 MSE: {mse_gd}")